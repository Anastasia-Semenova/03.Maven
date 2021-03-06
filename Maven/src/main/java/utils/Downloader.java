package utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Downloader{
	public void download(String files, String folder) {

		try(InputStream in = new URL(files).openStream()){
			Files.copy(in, Paths.get(folder));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}}