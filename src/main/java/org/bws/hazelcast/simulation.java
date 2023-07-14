package org.bws.hazelcast;
import java.util.List;
import org.bws.database.ReadData;
import org.bws.model.DataFrame;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class simulation {
@Inject
ReadData readData;
@Inject
Cluster hzCluster;

   
          @Transactional
           public void publish(){
            List<DataFrame> dataframes = readData.getServerIotFrames();
               for (DataFrame dataf : dataframes)
                    {
                        if(dataf.getApp()==1){
                             System.out.println("output "+ dataf.getData());
                             hzCluster.connection().getTopic("Topic").publish("THL Data Brut");
                                System.out.println("Topic Published");
                        }
                        
                    }
            // hzCluster.connection().getTopic("Topic").publish("dataf");}
            }
        }