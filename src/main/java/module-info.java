module com.quanlysieuthi.quanlysieuthimini {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires net.datafaker;

    requires com.almasb.fxgl.all;
    requires kotlin.stdlib;
    requires jakarta.persistence;
    requires lombok;
    exports com.quanlysieuthi.quanlysieuthimini.main;
}