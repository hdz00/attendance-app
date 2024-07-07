package com.attendanceapp.controller;

import com.attendanceapp.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String data) {
        byte[] qrCode = qrCodeService.generateQRCode(data);
        return ResponseEntity.ok().body(qrCode);
    }
}