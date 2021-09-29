package commonModule;

import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabletoDict {

           public static synchronized Map<String, String> TableDictionaryConverter(List<List<String>> data1) {
            //List<List<String>> data1=data.asList(String.class);
               Map<String, String> mapTable = new HashMap<String, String>();
            for(List<String> row: data1) {
                if (row.get(1) == null)
                    mapTable.put(row.get(0), "");
                else
                mapTable.put(row.get(0), row.get(1));
            }
            return mapTable;
        }

    }
