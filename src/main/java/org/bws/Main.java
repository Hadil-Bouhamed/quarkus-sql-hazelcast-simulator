package org.bws;

import java.util.List;

import org.bws.database.ReadData;
import org.bws.hazelcast.Cluster;
import org.bws.hazelcast.simulation;
import org.bws.model.DataFrame;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
@Inject
ReadData readData;
@Inject
Cluster hzCluster;
@Inject
simulation simulation1 ;

@Override
public int run(String... args) throws Exception {

hzCluster.createClient();
simulation1.publish();
return 0;
}

public static void main(String... args) {
Quarkus.run(Main.class, args);
}
}