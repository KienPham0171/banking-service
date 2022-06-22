package com.kienpham.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureUtil {
    public static String signData(String data, String privateKeyPath){
        try{
            //keypath
            //FileInputStream fis = new FileInputStream("/Users/Macpro/Desktop/KeyStore/privateKey.rsa");
            FileInputStream fis = new FileInputStream(privateKeyPath);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // create private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            Signature rsa = Signature.getInstance("SHA1withRSA");
            rsa.initSign(priKey);
            byte[] d = data.getBytes(StandardCharsets.UTF_8);
            rsa.update(d);
            byte[] signed = rsa.sign();
            return Base64.getEncoder().encodeToString(signed);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static boolean verifySignature(String dataString,String signatureString, String publicKeyPath) throws IOException {
        try {
            byte[] data = dataString.getBytes();
            byte[] signature  = Base64.getDecoder().decode(signatureString);

            //keypath
            //FileInputStream fis = new FileInputStream("/Users/Macpro/Desktop/KeyStore/publicKey.rsa");
            FileInputStream fis = new FileInputStream(publicKeyPath);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // create public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);

            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(pubKey);
            sig.update(data);
            return sig.verify(signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException |
            SignatureException | FileNotFoundException |
            InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }
}
