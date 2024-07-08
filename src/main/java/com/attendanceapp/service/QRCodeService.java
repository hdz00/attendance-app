package com.attendanceapp.service;

import com.util.QRCodeUtil;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String data) {
        return QRCodeUtil.generateQRCode(data);
    }

    public String decodeQRCode(InputStream inputStream) throws Exception {
        return QRCodeUtil.decodeQRCode(inputStream);
    }
}