package com.k48.managing.stock.service.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.k48.managing.stock.service.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;

@Service
@Slf4j
public class FlickrServiceImpl implements FlickrService {
    private static final Logger log = LoggerFactory.getLogger(FlickrServiceImpl.class);

    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;

    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

    private Flickr flickr;

    @Override
    public String savePhoto(InputStream photo, String title) {
        try {
            connect();
            UploadMetaData uploadMetaData = new UploadMetaData();
            uploadMetaData.setTitle(title);

            String photoId = flickr.getUploader().upload(photo, uploadMetaData);
            return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
        } catch (FlickrException e) {
            log.error("Error uploading photo to Flickr", e);
            throw new RuntimeException("Failed to upload photo to Flickr", e);
        }
    }

    private void connect() {
        flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }
}
