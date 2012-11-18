/* 
 * MyZip - A GUI for various command line compression programs.
 * Copyright (C) 2012  James Madley <jdmadley@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

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
