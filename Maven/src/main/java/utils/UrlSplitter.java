package utils;

import com.beust.jcommander.IStringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlSplitter implements IStringConverter<List<String>>{

    @Override
    public List<String> convert(String urls) {
        return new ArrayList<>(Arrays.asList(urls.split(";")));
    }
}