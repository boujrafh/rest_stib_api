package zip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import zip.metadata.StibMetadaLoader;
import zip.metadata.StibMetadataDownloader;

@RestController
public class StibMetadataController {

    private final StibMetadataDownloader downloader;
    private final StibMetadaLoader loader;

    public StibMetadataController(StibMetadataDownloader downloader, StibMetadaLoader loader) {
        this.downloader = downloader;
        this.loader = loader;
    }


    @RequestMapping(path = "/download", method = RequestMethod.PUT)
    public void downloalMetadata() {

        try {
            downloader.downloadData("gtfs.zip");

        }catch (RestClientException e){

            throw new DownloadException();
        }
    }

    @RequestMapping(path = "/loader", method = RequestMethod.PUT)
    public void loaderMetadata() {

        try {
            loader.loadZipToDb("gtfs_stib.zip");

        }catch (RestClientException e){

            throw new DownloadException();
        }
    }
}
