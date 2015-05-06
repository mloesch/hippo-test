package org.example.beans;

import java.util.UUID;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSetBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Node(jcrType = "myhippoproject:test")
public class TestDocument extends BaseDocument {

    private static final Logger LOG = LoggerFactory.getLogger(TestDocument.class);

    public static final String IMAGE = "myhippoproject:image";

    public HippoGalleryImageSetBean getBackgroundimage() {
        MDC.put("GET_BEAN_DEBUG", UUID.randomUUID().toString());
        final HippoGalleryImageSetBean linkedBean = getLinkedBean(IMAGE, HippoGalleryImageSetBean.class);
        try {
            if (linkedBean == null) {
                LOG.debug("background image for {} path={} with caption '{}' not found!", getNode().getIdentifier(),
                        getPath());
            } else {
                LOG.trace("background image for {} path={} with caption '{}': filename={}, original={}",
                        getNode().getIdentifier(), getPath(), linkedBean.getFileName(), linkedBean.getOriginal());
            }
            return linkedBean;
        } catch (RepositoryException e) {
            LOG.error("Could not load background image!", e);
            return linkedBean;
        } finally {
            MDC.remove("GET_BEAN_DEBUG");
        }
    }
}
