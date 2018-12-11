package edu.azure.constants;

public interface Constants {
	
	/**
	 * Connection String of the Blob
	 * for eg: 
	 * 
	 * DefaultEndpointsProtocol=https;AccountName=<accountName>;AccountKey=<primaryKey>;EndpointSuffix=core.windows.net";
	 * 
	 */
	String READ_AZURE_BLOB_CONNECTION_STRING = "<--Azure Storage Connection String-->";
	
	String WRITE_AZURE_BLOB_CONNECTION_STRING = "<--Azure Storage Connection String-->";
		
	// Name of the Container
	String READ_AZURE_BLOB_CONTAINER_NAME="<--Contiainer Name-->";
	String WRITE_AZURE_BLOB_CONTAINER_NAME="<--Contiainer Name-->";
	
	// Azure Blob Path
	String AZURE_READ_BLOB_PATH="<--Azure Blob Path -- Please ignore continaer name-->";
	String AZURE_WRITE_BLOB_PATH="<--Azure Blob Path -- Please ignore continaer name-->";
	
	String DOWNLOAD_FILE_PATH="<--Local File Path with File name-->";
	String WRITE_FILE_PATH="<--Local File Path with File name-->";
	
}
