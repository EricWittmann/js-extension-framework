js-extension-framework (JSEF)
=============================

A generic JavaScript extension framework.

ewittmann/poc1 - JSEF POC #1
----------------------------
Just open up ewittmann/poc1/host-app.html in your browser.  Then take a look at
all the code.  This POC is designed to show the core concepts of JSEF: expose
extension points and contribute functionality to those extension-points.

This POC has a host application that exposes two extension points.  It also has
two app extensions that both contribute to those extension points.

Not much complexity at this point - this just shows the ability to tie together
two applications.  It does this in a very naive way - basically by just exchanging
a JSON data object of a particular type.  The host application knows what to do
with that data.

ewittmann/poc1-gwt - JSEF POC #1 (GWT)
--------------------------------------
This is just a GWT version of the first POC above.  The result should be identical
to the first POC when viewed in the browser.  The difference is that the host
appliation is written in GWT rather than pure JavaScript.  Again, this is a naive
use of extensions - it's just an exchange of data using a JSON object.  This does
show the possibilities of integrating with GWT though.

ewittmann/poc2 - JSEF POC #2
----------------------------
This is a more advanced GWT proof of concept.  This time, two GWT applications are
integrated using JSEF.  This version showcases the following:

* Multiple GWT apps in DEV mode at the same time
* Passing GWT client beans from one GWT app to another
