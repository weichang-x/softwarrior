package com.softwarrior.web;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.softwarrior.rutrackerdownloader.RutrackerDownloaderApp;

import android.util.Log;

public class TorrentDownloader {
	
	String mCookieData;
	String mTorrentSavePath; 

	public TorrentDownloader(String CookieData, String TorrentSavePath)
	{
		mCookieData = CookieData;
		mTorrentSavePath = TorrentSavePath;
	}
	
	public void DownloadNNM(String DistributionNumber){				
		try{
			RutrackerDownloaderApp.TorrentFullFileName = mTorrentSavePath + "/" + "[" + DistributionNumber + "]" + ".torrent";
			URL url = new URL(RutrackerDownloaderApp.NN_TorrentDL + DistributionNumber);				
			URLConnection connection = url.openConnection();
			HttpURLConnection httpget = (HttpURLConnection) connection;
			httpget.setDoInput(true);

			httpget.setRequestMethod("GET");

			httpget.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; ru; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2");
			httpget.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httpget.setRequestProperty("Referer", RutrackerDownloaderApp.TorrentTopic + DistributionNumber);

			httpget.connect();
			InputStream inputStream = httpget.getInputStream();
	        if(inputStream != null) {
				FileOutputStream fos = new FileOutputStream(RutrackerDownloaderApp.TorrentFullFileName);
				int length = 0;
				byte [] data = new byte[256];
		        while ((length = inputStream.read(data)) != -1) {
		            fos.write(data,0,length);
		        }
		        inputStream.close();
	    		fos.flush();
	    		fos.close();  
	        }
		} catch (Exception ex){
			Log.e(RutrackerDownloaderApp.TAG, ex.toString());
	    }
	}
	
	public void Download(String DistributionNumber){
		try{
			RutrackerDownloaderApp.TorrentFullFileName = mTorrentSavePath + "/" + "[" + DistributionNumber + "]" + ".torrent";
			URL url = new URL(RutrackerDownloaderApp.TorrentDL + DistributionNumber);				
			URLConnection connection = url.openConnection();
			HttpURLConnection httppost = (HttpURLConnection) connection;
			httppost.setDoInput(true);
		    httppost.setDoOutput(true);

		    httppost.setRequestMethod("POST");

			httppost.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; ru; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2");
		    httppost.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		    httppost.setRequestProperty("Accept-Language", "ru,en-us;q=0.7,en;q=0.3");
		    httppost.setRequestProperty("Accept-Encoding", "gzip,deflate");
		    httppost.setRequestProperty("Accept-Charset", "windows-1251,utf-8;q=0.7,*;q=0.7");
		    httppost.setRequestProperty("Keep-Alive", "300");
		    httppost.setRequestProperty("Connection", "keep-alive");
		    httppost.setRequestProperty("Referer", RutrackerDownloaderApp.TorrentTopic + DistributionNumber);
		    httppost.setRequestProperty("Cookie", mCookieData + "; bb_dl=" + DistributionNumber);
		    httppost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httppost.setRequestProperty("Content-Length", "0");

		    //PrintMapWithList(httppost.getHeaderFields());
		    
		    //DataOutputStream dos = new DataOutputStream(httppost.getOutputStream());
		    //dos.write(b); // bytes[] b of post data

			InputStream inputStream = httppost.getInputStream();
	        if(inputStream != null) {
				FileOutputStream fos = new FileOutputStream(RutrackerDownloaderApp.TorrentFullFileName);
				int length = 0;
				byte [] data = new byte[256];
		        while ((length = inputStream.read(data)) != -1) {
		            fos.write(data,0,length);
		        }
		        inputStream.close();
	    		fos.flush();
	    		fos.close();  
	        }
//			String torrentName = DownloadService.GetTorrentName(RutrackerDownloaderApp.TorrentFullFileName);
//			if(torrentName != null){
//				if(torrentName.length() > 16){
//					torrentName = torrentName.substring(0, 8);
//					torrentName += ".torrent";
//				}
//				inputStream = new FileInputStream(RutrackerDownloaderApp.TorrentFullFileName);	
//		        if(inputStream != null) {
//			        int chr = 0;
//					FileOutputStream fos = new FileOutputStream(mTorrentSavePath + "/" + torrentName); 
//			        while ((chr = inputStream.read()) != -1) {
//			            fos.write(chr);
//			        }
//			        inputStream.close();
//		    		fos.flush();
//		    		fos.close();
//		    		File file = new File(RutrackerDownloaderApp.TorrentFullFileName); 
//		    		file.delete();
//			        RutrackerDownloaderApp.TorrentFullFileName = mTorrentSavePath + "/" + torrentName;
//		        }
//			}
	       // String reply = sb.toString();		        	    		
		} catch (Exception ex){
			Log.e(RutrackerDownloaderApp.TAG, ex.toString());
	    }
	}
	
//    void PrintMapWithList(Map<String, List<String>> MapList)
//    {
//        Set map_set = MapList.entrySet();
//        Iterator map_it = map_set.iterator();
//        
//        while(map_it.hasNext())
//        {
//            Map.Entry map_entry =(Map.Entry)map_it.next();
//            String key=(String)map_entry.getKey();
//            String resultText = key;
//            resultText += ": ";
//            List<String> value_list=(List<String>)map_entry.getValue();	            
//            Iterator list_it=value_list.iterator();
//            while(list_it.hasNext())
//            {
//              String value=(String)list_it.next();
//              resultText += value;
//            }
//            Log.i(RutrackerDownloaderApp.TAG ,resultText);
//        }
//    }
}
