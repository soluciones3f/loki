// var casper = require('casper').create();

// hello-test.js
casper.test.begin("Hello, Test!", 1, function(test) {
  test.assert(true);
  test.done();
});

// casper.run();