package edu.azure.blob.copier;

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
 * Class to copy a blob from one specific path into another path.
 *
 */
public class CopyBlob {
	
	// Storage account information
	static CloudStorageAccount readStorageAccount;
	static CloudStorageAccount writeStorageAccount;
	
	static CloudBlobClient readBlobClient;
	static CloudBlobClient writeBlobClient;
	
	static CloudBlobContainer readContainer;
	static CloudBlobContainer writeContainer;
	
	public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException, IOException {
		// TODO Auto-generated method stub
		
		// Parse the connection string and create a blob client to interact with Blob storage
		readStorageAccount = CloudStorageAccount.parse(Constants.READ_AZURE_BLOB_CONNECTION_STRING);
		readBlobClient = readStorageAccount.createCloudBlobClient();
		readContainer = readBlobClient.getContainerReference(Constants.READ_AZURE_BLOB_CONTAINER_NAME);
		
		// Parse the connection string and create a blob client to interact with Blob storage
		writeStorageAccount = CloudStorageAccount.parse(Constants.WRITE_AZURE_BLOB_CONNECTION_STRING);
		writeBlobClient = writeStorageAccount.createCloudBlobClient();
		writeContainer = writeBlobClient.getContainerReference(Constants.WRITE_AZURE_BLOB_CONTAINER_NAME);

		copyFile();
					 
	}
	
	public static void copyFile() throws URISyntaxException, StorageException, IOException {
				
		// Get the read blob instance
		CloudBlockBlob readblob = readContainer.getBlockBlobReference(Constants.AZURE_READ_BLOB_PATH);
		
		// Get the write blob instance
		CloudBlockBlob writeblob = writeContainer.getBlockBlobReference(Constants.AZURE_WRITE_BLOB_PATH);
		
		// Copy the blob from one instance into another
		writeblob.upload(readblob.openInputStream(),-1);
		
		System.out.println("File Copied Successfully");
				
		}
	}

