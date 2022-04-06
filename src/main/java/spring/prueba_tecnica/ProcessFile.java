package spring.prueba_tecnica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProcessFile {
    
    private static boolean isValidAlgorithm(String algorithm) {
        String validAlgorithm[] = {"SHA-256", "SHA-512"};
        boolean valid = false;

        for(int i=0; i<validAlgorithm.length; i++) {
            if(validAlgorithm[i].compareTo(algorithm) == 0) {
                valid = true;
                break;
            }
        }

        return valid;
    }

    private static byte[] getMessageDigest(byte[] message, String algorithm) {
        byte[] digest = {};
        
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(message);
		
			digest = md.digest(); 

        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

        return digest;
    }

    public static String getContent(String path) throws IOException {
        String content = "";

		FileReader file = new FileReader(path);
		BufferedReader buffer = new BufferedReader(file);
        
        for (;;) {
            String line = buffer.readLine();
            if (line == null) {
                buffer.close(); 
                break;
            }
            
            content += line;
        }
               
        return content;
    }

    public static String getHash(String content, String algorithm) throws Exception {
        if(! ProcessFile.isValidAlgorithm(algorithm)) {
            throw new Exception("Algoritmo no soportado ");
        }

        byte[] digest = ProcessFile.getMessageDigest(content.getBytes(), algorithm);

		StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<digest.length;i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}

        return hexString.toString();
    } 
}
