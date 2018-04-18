package deepin.com.zxing;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mylhyl.zxing.scanner.ScannerView;
import com.mylhyl.zxing.scanner.encode.QREncode;
import com.mylhyl.zxing.scanner.result.AddressBookResult;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private ScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScannerView = findViewById(R.id.scanner_view);

        // 生成二维码并显示
        try {
            ((ImageView)findViewById(R.id.id_show_iamge)).setImageBitmap(bitMatrixToBitmap(encodeQR("hello world!")));
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        mScannerView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mScannerView.onPause();
        super.onPause();
    }

    /**
     * 生成二维码
     *
     * @param contents 二维码内容
     * @return 二维码的描述对象 BitMatrix
     * @throws WriterException 编码时出错
     */
    private BitMatrix encodeQR(String contents) throws WriterException {
        final Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        return new QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, 320, 320, hints);
    }

    private Bitmap bitMatrixToBitmap(BitMatrix bitMatrix) {
        final int width = bitMatrix.getWidth();
        final int height = bitMatrix.getHeight();

        final int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y * width + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

        return bitmap;
    }

}
