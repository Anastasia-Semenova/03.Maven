package app;

import com.beust.jcommander.JCommander;
import thread.ThreadPool;
import utils.Downloader;
import utils.UrlSplitter;

import java.util.List;

public class Program{
	public static void main(String argv[]){

		Args args= new Args();
		JCommander.newBuilder().
		addObject(args).
		build().
		parse(argv);

		Downloader downloader = new Downloader();

		UrlSplitter converter = new UrlSplitter();

		if(args.mode.equals("one-thread")){
	downloader.
		download(
			args.files,
			args.folder);
	} else if(args.mode.equals("multi-thread")){
		  ThreadPool threadPool = new ThreadPool(args.count);
		  List<String> urls = converter.convert(args.files);

            while(!urls.isEmpty()){

                Runnable task = () -> {
                    downloader.download(urls.remove(0), args.folder);
                };

                threadPool.submit(task);
	}
	}
}
}