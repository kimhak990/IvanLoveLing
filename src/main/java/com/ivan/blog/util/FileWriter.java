package com.ivan.blog.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * File 쓰기
 * 작성일 : 2016. 3. 11.
 * 작성자 : Freebee
 * </pre>
 * @author Freebee
 */
@Service
public class FileWriter {
	
	/**
	 * Method 설명 : File Copy
	 * 작성일 : 2016. 3. 9.
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public static void copy(File source, File dest) throws IOException {
		File parentFile = null;

		if (source.isDirectory()) {
			if (!(dest.exists())) {
				dest.mkdirs();
			} else if (dest.isDirectory()) {
				dest = new File(dest, source.getName());
				dest.mkdirs();
			}

			if (dest.isDirectory()) {
				File[] slist = source.listFiles();
				for (int i = 0; i < slist.length; ++i)
					if (slist[i].isDirectory())
						copy(slist[i], new File(dest, slist[i].getName()));
					else
						copy(slist[i], dest);
				return;
			}
			throw new IOException( "file copy error : not directory copy file : " + dest );
		}

		if ((source.isFile()) && (dest.isDirectory())) {
			parentFile = new File(dest.getAbsolutePath());
			dest = new File(dest, source.getName());
		} else {
			parentFile = new File(dest.getParent());
		}

		parentFile.mkdirs();

		if (!(source.canRead())) {
			throw new IOException("Cannot read file '" + source + "'.");
		}

		if ((dest.exists()) && (!(dest.canWrite()))) {
			throw new IOException("Cannot write to file '" + dest + "'.");
		}
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] buffer = new byte[1024];
		int read = -1;
		while ((read = bin.read(buffer, 0, 1024)) != -1)
			bout.write(buffer, 0, read);
		bout.flush();
		bout.close();
		bin.close();
	}
}
