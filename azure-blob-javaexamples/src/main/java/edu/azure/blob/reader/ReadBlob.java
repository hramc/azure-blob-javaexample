package edu.azure.blob.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import edu.azure.constants.Constants;

/**
 * 
 * @author hramc
 * 
 * Class to download a specific blob to the local file system
 *
 */

public class ReadBlob {
	
	// Storage account information
	static CloudStorageAccount readStorageAccount;
	
	static CloudBlobClient readBlobClient;
	
	static CloudBlobContainer readContainer;

	public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException, IOException {
		// TODO Auto-generated method stub
		
		// Parse the connection string and create a blob client to interact with Blob storage
		readStorageAccount = CloudStorageAccount.parse(Constants.READ_AZURE_BLOB_CONNECTION_STRING);
		readBlobClient = readStorageAccount.createCloudBlobClient();
		readContainer = readBlobClient.getContainerReference(Constants.READ_AZURE_BLOB_CONTAINER_NAME);
				
		// Download a file from a particular path
		CloudBlockBlob readblob = readContainer.getBlockBlobReference(Constants.AZURE_READ_BLOB_PATH);
		readblob.downloadToFile(Constants.DOWNLOAD_FILE_PATH);
		
		System.out.println("File Downloaded Successfully");
	}

}
