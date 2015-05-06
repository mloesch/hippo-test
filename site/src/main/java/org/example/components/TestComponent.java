package org.example.components;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class TestComponent extends BaseHstComponent {

    public static final Logger LOG = LoggerFactory.getLogger(TestComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {
        HippoBean contentBean = request.getRequestContext().getContentBean();

        if (contentBean == null) {
            LOG.info("Did not find a content bean for relative content path '{}' for pathInfo '{}'",
                    request.getRequestContext().getResolvedSiteMapItem().getRelativeContentPath(),
                    request.getRequestContext().getResolvedSiteMapItem().getPathInfo());
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        request.setAttribute("document", contentBean);
    }
}
