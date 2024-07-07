package com.attendanceapp.service;

import com.attendanceapp.util.QRCodeUtil;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {
    public byte[] generateQRCode(String data) {
        return QRCodeUtil.generateQRCode(data);
    }
}