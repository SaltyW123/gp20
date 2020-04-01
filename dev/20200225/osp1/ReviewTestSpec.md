
# Issues

* Sections should be in caps, sub sections start with a capital Ref: SE.QA.02, 3.2
* the "1" in "Section 1.3" hasn't got the same weight as the rest of the line
* Copyright needs to be dated 2020 not 2016
* If following the standards for config refs started in the UI Spec docs your ref should be: TestSpecGroup20
* The title of the document should just be "Test Specification", "test procedure standards" is SE.QA.06 which describes how you are meant to write this document
* There document doesn't completely reflect the template shown on blackboard, font sizes and formatting. Also when exporting the indexes should be generated for PDFs but aren't.
* GR20T1, Test Content - has unnecessary capital letters (That, Words)
* GR20T5, Output - possibly change the word "updated" to "added" to be more specific
* GR20T12, GR20T13, GR20T14 - name of tests could match the names given in the UISpec. This should help prevent confusion, either change them or report an issue for the UISpec docs to have it changed to the names that are chosen in the Test Spec (Names chosen in the Test Spec seem a lot simpler and nicer to me personally)
* Same with the slight changes in terminology "Study"/"Test" etc
* GR20T9 - the program only shows "masculine noun", "feminine noun" next to Welsh words, the way the program shows if a word is a verb is the English translation will be prefaced with "to", see UI and FR6
* Section 3, 2nd Para, "...testing, Module, system..." random capitalisation 
* Scope of the document: This document describes how the software will be tested and what parts of it will be tested
  * The standards are what se.qa.06 is doing - not what this document is doing
* Objectives are provide a clear plan for testing and to describe the general approach to testing, the test plan and  test specification
  * Again the formatting and information that must be supplied are detailed in se.qa.06 and not this document.
* Section 4 "Module testing;" should be colon not a semi-colon

  # Issues/Inconsistencies it has highlighted in the UI Spec
* In the assignment spec FR9 and F10 mentions a collection of tests are randomly selected, in the UI Spec the user has the choice to click on which version they want. This needs to be changed, the QA manager needs to report this issue on GitLab.
  * This means the "Match" test type shouldn't come up in the random tests if there are less than 4 practice words.
  * As this change will be made to the UI Spec your test spec should also reflect this
  * If we make this change now it makes writing the software easier