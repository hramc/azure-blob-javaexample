package edu.azure.blob.writer;

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
 * Class to upload a specific local file into Azure blob
 *
 */
public class uploadBlob {

	// Storage account information
	static CloudStorageAccount writeStorageAccount;
	
	static CloudBlobClient writeBlobClient;
	
	static CloudBlobContainer writeContainer;

	public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException, IOException {
		// TODO Auto-generated method stub
		
		// Parse the connection string and create a blob client to interact with Blob storage
		writeStorageAccount = CloudStorageAccount.parse(Constants.READ_AZURE_BLOB_CONNECTION_STRING);
		writeBlobClient = writeStorageAccount.createCloudBlobClient();
		writeContainer = writeBlobClient.getContainerReference(Constants.READ_AZURE_BLOB_CONTAINER_NAME);
				
		// upload a file from a particular path
		CloudBlockBlob writeblob = writeContainer.getBlockBlobReference(Constants.AZURE_WRITE_BLOB_PATH);
		writeblob.uploadFromFile(Constants.WRITE_FILE_PATH);
		
		System.out.println("File Uploaded Successfully");
	}


}
