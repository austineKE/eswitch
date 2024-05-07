package com.tech.eswitch.utils;

import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;


public class SecurityCredentialsGenerator {


    public String generateSecurityCredentials(String password, boolean isOnProduction) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String fileName = isOnProduction ? "certs/ProductionCertificate.cer" :
                    "certs/SandboxCertificate.cer";

            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) certFactory
                    .generateCertificate(classLoader.getResourceAsStream(fileName));

            PublicKey publicKey = cert.getPublicKey();
            if (!(publicKey instanceof RSAPublicKey)) {
                throw new IllegalArgumentException("Certificate does not contain an RSA public key");
            }
            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;

            Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            rsaCipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);

            byte[] encryptedPayload = rsaCipher.doFinal(password.getBytes());

            return Base64.getEncoder().encodeToString(encryptedPayload);
        } catch (Exception e) {
            return null;
        }
    }

//    String password = PropertyReader.getProperty("eSwitch.send.money.securityCredential");
//    boolean isOnProduction = true; // or false based on your environment
//    SecurityCredentialsGenerator securityCredentialsGenerator=new SecurityCredentialsGenerator();
//    String credentials = securityCredentialsGenerator.generateSecurityCredentials(password, isOnProduction);


}
