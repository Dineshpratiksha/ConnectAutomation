package SBV_utility;

import java.io.File;

public class DownloadedFilesOperations {
	public static String isFileDownlodedName(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		for(int i= 0; i < dir_contents.length;i++) {
			if(dir_contents[i].getName().contains(fileName)) {
				System.out.println(i+"i");
				System.out.println(dir_contents[i].getName());
				return dir_contents[i].getName();
			}
		}
		
		return null;
		
	}
	
	public static File deleteLatestFilefromDir(String dirPath) {
		System.out.println("Delete file");
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if(files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for(int i=1;i<files.length; i++) {
			if(lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		System.out.println(lastModifiedFile.getName());
		lastModifiedFile.delete();
		return lastModifiedFile;
		
	}
	
	public static String deleteLatestReportfromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		String fileName="";
		if(files == null || files.length == 0) {
			return null;
		}
		for(int i=1;i<files.length; i++) {
			if(files[i].getName().contains("PropertyListReportExport_")) {
				fileName=files[i].getName();
				files[i].delete();
			}
		}
		return fileName;
		
	}
	
	public static void verifyNewFile(String fileName) throws InterruptedException {
		String home= System.getProperty("user.dir")+ File.separator + "TestData"+ File.separator +"downloadFiles" +File.separator;
		String file_name = fileName+".pdf";
		String file_with_location=home + file_name;
		File file = new File(file_with_location);
		if(file.exists()) {
			Logs.info(file_with_location + "is Present");
			Thread.sleep(1000);
			if (file.delete()) {
				Logs.info("file deleted");
				System.out.println("file deleted");
			}else {
				ExceptionHandling.HandleAssertion("file not deleted");
			}
		}else {
			ExceptionHandling.HandleAssertion(file_with_location + "is not present");

		}
	}
	
	public static void verifyNewTiffFile(String fileName) throws InterruptedException {
		String home= System.getProperty("user.dir")+ File.separator + "TestData"+ File.separator +"downloadFiles" +File.separator;
		String file_name = fileName+".tiff.tif";
		String file_with_location=home + file_name;
		File file = new File(file_with_location);
		if(file.exists()) {
			Logs.info(file_with_location + "is Present");
			Thread.sleep(1000);
			if (file.delete()) {
				Logs.info("file deleted");
				System.out.println("file deleted");
			}else {
				ExceptionHandling.HandleAssertion("file not deleted");
			}
		}else {
			ExceptionHandling.HandleAssertion(file_with_location + "is not present");

		}
	}

}
