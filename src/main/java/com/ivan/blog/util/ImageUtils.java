package com.ivan.blog.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * <pre>
 * 이미지 관련 처리
 * 작성일 : 2016. 3. 11.
 * 작성자 : Freebee
 * </pre>
 * @author Freebee
 */
public class ImageUtils {

    public static final int RATIO = 0;
    public static final int SAME = -1;


    /**
     * Method 설명 : Web Editor Thumbnail 처리
     * 작성일 : 2016. 3. 9.
     * @param src
     * @param dest
     * @param width
     * @throws IOException
     */
    public static void thumbnail(File src, File dest, int width)
    		throws IOException {

    	if(!src.exists()){
    		String filename = CommonUtil.toJavaPath(src.getAbsolutePath());
        	src = new File(filename);
        }
    	if(!dest.exists()){
        	String filename = CommonUtil.toJavaPath(dest.getAbsolutePath());
        	dest = new File(filename);
        }

    	Image srcImg = getImageObject(src);
        int srcWidth = srcImg.getWidth(null);

        //if(srcWidth > width) {
        	FileWriter.copy(src, dest);
        	resize(dest, dest, width, RATIO);
        //}
    }

    public static void rectThumbnail(File src, File dest, int width)
            throws IOException {

        if(!src.exists()){
            String filename = CommonUtil.toJavaPath(src.getAbsolutePath());
            src = new File(filename);
        }
        if(!dest.exists()){
            String filename = CommonUtil.toJavaPath(dest.getAbsolutePath());
            dest = new File(filename);
        }

        Image srcImg = getImageObject(src);
        int srcWidth = srcImg.getWidth(null);

        //if(srcWidth > width) {
            FileWriter.copy(src, dest);
            resize(dest, dest, width, width);
        //}
    }
    
    /**
     * @Task thumnail Image 가로 세로 지정 
     * @MethodName rectThumbnail
     * @param src
     * @param dest
     * @param width
     * @param height
     * @throws IOException
     * @return void
     * @date 2016. 8. 4.
     * @author tk.kang
     */
    public static void rectThumbnail(File src, File dest, int width, int height) throws IOException {
        if(!src.exists()){
            String filename = CommonUtil.toJavaPath(src.getAbsolutePath());
            src = new File(filename);
        }
        if(!dest.exists()){
            String filename = CommonUtil.toJavaPath(dest.getAbsolutePath());
            dest = new File(filename);
        }

        FileWriter.copy(src, dest);
        resize(dest, dest, width, height);
    }

    /**
     * Method 설명 : 이미지 리사이즈, 주로 썸네일 제작에 사용
     * 작성일 : 2016. 3. 9.
     * @param src
     * @param dest
     * @param width
     * @param height
     * @throws IOException
     */
    public static void resize(File src, File dest, int width, int height)
    		throws IOException {

    	if(!src.exists()){
    		String filename = CommonUtil.toJavaPath(src.getAbsolutePath());
        	src = new File(filename);
        }
    	if(!dest.exists()){
        	String filename = CommonUtil.toJavaPath(dest.getAbsolutePath());
        	dest = new File(filename);
        }

    	Image srcImg = getImageObject(src);
        int srcWidth = srcImg.getWidth(null);
        int srcHeight = srcImg.getHeight(null);

        int destWidth = -1, destHeight = -1;

        if (width == SAME) {
            destWidth = srcWidth;
        } else if (width > 0) {
            destWidth = width;
        }

        if (height == SAME) {
            destHeight = srcHeight;
        } else if (height > 0) {
            destHeight = height;
        }

        if (width == RATIO && height == RATIO) {
            destWidth = srcWidth;
            destHeight = srcHeight;
        } else if (width == RATIO) {
            double ratio = ((double)destHeight) / ((double)srcHeight);
            destWidth = (int)((double)srcWidth * ratio);
        } else if (height == RATIO) {
            double ratio = ((double)destWidth) / ((double)srcWidth);
            destHeight = (int)((double)srcHeight * ratio);
        }

        /**
         * 	static int SCALE_AREA_AVERAGING
         * 	Area Averaging 이미지 슬캘링 알고리즘을 사용합니다.
		 *	static int SCALE_DEFAULT
         * 	디폴트의 이미지 슬캘링 알고리즘을 사용합니다.
		 *	static int SCALE_FAST
         *  	슬캘링 후의 이미지의 매끄러움보다 슬캘링 속도에 높은 우선 순위를 주는 이미지 슬캘링 알고리즘을 선택합니다.
		 *	static int SCALE_REPLICATE
         * 	ReplicateScaleFilter 클래스에서 구체화된 이미지 슬캘링 알고리즘을 사용합니다.
		 *	static int SCALE_SMOOTH
         * 	슬캘링 속도보다 이미지의 매끄러움에 높은 우선 순위를 주는 이미지 슬캘링 알고리즘을 선택합니다.
         *   png이미지 사용
         */
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_FAST);
        int pixels[] = new int[destWidth * destHeight];
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight, pixels, 0, destWidth);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
        BufferedImage destImg = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_3BYTE_BGR);
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);

        //png 로 파일타입 변경시 파일용량이 늘어남 - 2016.7.11 (jm.ahn)
        ImageIO.write(destImg, "jpg", dest);
    }

    /**
     * Method 설명 : Image File File Read
     * 작성일 : 2016. 3. 9.
     * @param f
     * @return
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
	private static Image getImageObject(File f) throws IOException {
        Image objImg = null;
        String suffix = f.getName().substring(f.getName().lastIndexOf('.')+1).toLowerCase();
        // java.lang.ArrayIndexOutOfBoundsException: 4096 GIF 이미지버그로 인한 설정 제외  
        if (suffix.equals("bmp") || suffix.equals("png")) {
        	objImg = ImageIO.read(f);
        } else {
        	objImg = new ImageIcon(f.toURL()).getImage();
        }
        return objImg;
    }
    
}
