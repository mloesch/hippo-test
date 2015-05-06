
<%--
  Created by IntelliJ IDEA.
  User: ijundi
  Date: 06.05.2015
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title></title>
</head>
<body>
<hst:link var="img" hippobean="${document.backgroundimage}"/>
test
<img
        src="${img}" alt="${fn:escapeXml(image.description)}" />
</body>
</html>
