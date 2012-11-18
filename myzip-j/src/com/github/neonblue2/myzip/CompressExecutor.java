package com.github.neonblue2.myzip;

public class CompressExecutor {
	public enum Tar {
		GNUTAR, BSDTAR
	}
	
	public enum ProcessType {
		SEQUENTIAL, PARALLEL
	}
	
	private enum NZip {
		BZIP2, GZIP
	}
	
	public static void zip(String[] args, int level, String[] files, String outputPath, boolean useEncryption, boolean use7zip) {
		// TODO: Write method...
	}
	
	public static void tar(String[] args, String[] files, String outputPath, Tar type) {
		// TODO: Write method...
	}
	
	private static void nZip(String[] args, String file, String outputPath, ProcessType type, NZip method, boolean use7zip) {
		// TODO: Write method...
	}
	
	public static void bzip2(String[] args, String file, String outputPath, ProcessType type, boolean use7zip) {
		nZip(args, file, outputPath, type, NZip.BZIP2, use7zip);
	}
	
	public static void gzip(String[] args, String file, String outputPath, ProcessType type, boolean use7zip) {
		nZip(args, file, outputPath, type, NZip.GZIP, use7zip);
	}
}
