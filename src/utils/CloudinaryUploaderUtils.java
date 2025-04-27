package utils;

import java.io.File;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


public class CloudinaryUploaderUtils {
	private static Cloudinary cloudinary;

    static {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dtuhfcdph", 
            "api_key", "276652975174167",     
            "api_secret", "26tTzuq5UxeUKTRbzlpPXCJEpqw"    
        ));
    }

    public static String uploadImage(File file) throws Exception {
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        return (String) uploadResult.get("secure_url");  // Lấy URL an toàn (https) của ảnh
    }
}
