module com.quanlysieuthi.quanlysieuthimini {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires net.datafaker;
    opens com.quanlysieuthi.quanlysieuthimini to javafx.fxml;

    opens com.quanlysieuthi.quanlysieuthimini.entity to jakarta.persistence, org.hibernate.orm.core;
    requires com.almasb.fxgl.all;

    requires kotlin.stdlib;
    requires jakarta.persistence;
    requires lombok;
    exports com.quanlysieuthi.quanlysieuthimini.main;
    exports com.quanlysieuthi.quanlysieuthimini.entity;
    uses net.datafaker.idnumbers.IdNumberGenerator;
}