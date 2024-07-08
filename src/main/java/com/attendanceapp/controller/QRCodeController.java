package com.attendanceapp.controller;

import com.attendanceapp.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateQRCode(@RequestParam String data) {
        try {
            String[] parts = data.split(",");
            String funcionarioId = parts[0];
            byte[] qrCode = qrCodeService.generateQRCode(data);
            String filename = "qr_code_" + funcionarioId + ".png";

            File file = new File(filename);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(qrCode);
            }

            return ResponseEntity.ok(filename);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to generate QR Code: " + e.getMessage());
        }
    }

    @PostMapping("/scan")
    public ResponseEntity<String> scanQRCode(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String data = qrCodeService.decodeQRCode(inputStream);
            // Assume you have an attendanceService to handle the extracted data
            // attendanceService.registerAttendanceFromQRCode(data);
            return ResponseEntity.ok("Attendance registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to register attendance: " + e.getMessage());
        }
    }
}