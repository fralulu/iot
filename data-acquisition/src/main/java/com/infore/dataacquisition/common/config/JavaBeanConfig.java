package com.infore.dataacquisition.common.config;


import com.infore.platform.core.common.utils.Asserts;
import com.infore.platform.core.common.utils.pdf.LibreOffice2Pdf;
import com.infore.platform.core.common.utils.uuid.UUIDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class JavaBeanConfig {

    @Bean
    public UUIDGenerator uuidGenerator() {
        return new UUIDGenerator();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Asserts asserts() {
        Asserts asserts = new Asserts();
        asserts.setRequestId(uuidGenerator().getId());
        return asserts;
    }

    @Bean
    public LibreOffice2Pdf libreOffice2Pdf() {
        return new LibreOffice2Pdf();
    }

}