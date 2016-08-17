package zip.metadata;

import org.springframework.stereotype.Component;
import zip.InputStreamFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@Component
public class StibMetadaLoaderImpl implements StibMetadaLoader {

    private final InputStreamFactory isf;

    private final Loader agenciesLoader;
    private final Loader calendarsLoader;
    private final Loader calendarsDatesLoader;
    private final Loader routesLoader;
    private final Loader shapesLoader;
    private final Loader stopsTimesLoader;
    private final Loader stopsLoader;
    private final Loader translationsLoader;
    private final Loader tripsLoader;


    public StibMetadaLoaderImpl(InputStreamFactory isf, Loader agenciesLoader, Loader calendarsLoader,
                                Loader calendarsDatesLoader, Loader routesLoader, Loader shapesLoader,
                                Loader stopsTimesLoader, Loader stopsLoader, Loader translationsLoader,
                                Loader tripsLoader) {
        this.isf = isf;
        this.agenciesLoader = agenciesLoader;
        this.calendarsLoader = calendarsLoader;
        this.calendarsDatesLoader = calendarsDatesLoader;
        this.routesLoader = routesLoader;
        this.shapesLoader = shapesLoader;
        this.stopsTimesLoader = stopsTimesLoader;
        this.stopsLoader = stopsLoader;
        this.translationsLoader = translationsLoader;
        this.tripsLoader = tripsLoader;
    }


    @Override
    public void loadZipToDb(String zipFilePath) {
        try {
            ZipInputStream zis = new ZipInputStream(isf.getInputStreamFromFile(zipFilePath));
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                if(!entry.isDirectory()) {
                    dealWithFile(entry.getName(), zis);
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
            zis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void dealWithFile(String fileName, ZipInputStream zis) {
        BufferedReader br = new BufferedReader(new InputStreamReader(zis, StandardCharsets.UTF_8));
        System.out.println("name of file: " + fileName);
        if(fileName.equals("agency.txt")){
            agenciesLoader.loadToDb(br);
        }
        else if(fileName.equals("calendar.txt")) {
            calendarsLoader.loadToDb(br);
        }
        else if(fileName.equals("calendar_dates.txt")) {
            calendarsDatesLoader.loadToDb(br);
        }
        else if (fileName.equals("routes.txt")) {
            routesLoader.loadToDb(br);
        }
        else if(fileName.equals("shapes.txt")) {
            shapesLoader.loadToDb(br);
        }
        else if(fileName.equals("stop_times.txt")) {
            stopsTimesLoader.loadToDb(br);
        }
        else if(fileName.equals("stops.txt")) {
            stopsLoader.loadToDb(br);
        }
        else if(fileName.equals("translations.txt")) {
            translationsLoader.loadToDb(br);
        }
        else if(fileName.equals("trips.txt")) {
            tripsLoader.loadToDb(br);
        }
        else {
            throw new RuntimeException("this file should not exist: " + fileName);
        }
    }

}

