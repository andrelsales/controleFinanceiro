package com.liv.controlefinanceiro.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

	private static final Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public void uploadFile(String localFilePath) {

		try {

			File file = new File(localFilePath);
			s3client.putObject(new PutObjectRequest(bucketName, "teste", file));
			LOG.info("upload FINALIZADO NA AMAZON");

		} catch (AmazonServiceException e) {
			LOG.info("AmazonServiceException : " + e.getMessage());
			LOG.info("STATUS CODE : " + e.getErrorCode());
		} catch (AmazonClientException e) {
			LOG.info("AmazonServiceException : " + e.getMessage());
			LOG.info("STATUS CODE : ");
		}

	}
}
