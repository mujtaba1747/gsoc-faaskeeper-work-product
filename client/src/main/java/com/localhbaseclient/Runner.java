package com.localhbaseclient;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class Runner {
        public void connect() throws IOException {
        try {
            Configuration config = HBaseConfiguration.create();

            String path = "src/resources/hbase-site.xml";
    
            config.addResource(new Path(path));
    
            try {
                HBaseAdmin.available(config);
            } catch (MasterNotRunningException e) {
                System.out.println("HBase is not running." + e.getMessage());
                return;
            }
    
            HBaseClientOperations HBaseClientOperations = new HBaseClientOperations();
            HBaseClientOperations.run(config);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
