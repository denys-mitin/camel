package rampup.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/*
  It is draft. Mapping and check for new records are also required.
 */
public class FromCassandraToElasticSearch {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("cql:localhost/ramp_up").to("elasticsearch://local?operation=INDEX&indexName=ramp_up&indexType=visit");
            }
        });
        context.start();
    }
}
