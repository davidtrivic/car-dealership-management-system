module org.unibl.etf.projekat_bazepodataka {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires atlantafx.base;

    opens org.unibl.etf.projekat_bazepodataka to javafx.fxml;
    //exports org.unibl.etf.projekat_bazepodataka;
    exports org.unibl.etf.projekat_bazepodataka.ui;
    exports org.unibl.etf.projekat_bazepodataka.util;
    exports org.unibl.etf.projekat_bazepodataka.dao;
    exports org.unibl.etf.projekat_bazepodataka.model;
    opens org.unibl.etf.projekat_bazepodataka.ui to javafx.fxml;
}