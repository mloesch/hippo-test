# How to reproduce the image loading problem

This demo project contains a simple page (``TestDocument.java``) referencing an image via ``getLinkedBean()``.
It can be used to provoke the resource loading problem (``getBean()`` returning ``null``) under load.

## Prerequisites:

- Java 1.7.0_80
- Tomcat 7.0.61

## How to reproduce:

- Deploy to external Tomcat + run in debug mode (NOTE: running using Cargo probably won't work,
because the Tomcat started by Cargo won't handle enough concurrent requests to provoke the problem).
- Set breakpoint in ``TestDocument.java`` in the ``linkedBean == null`` if-block.
- Create load on http://localhost:8080/site/test-doc by using Apache ab:

    ``$ ab -c 100 -n 50000 http://localhost:8080/site/test-doc``

- After a short time, you should run into the breakpoint. Having occurred once, the problem is likely
to occur again on subsequent requests (probably due to caching?).
