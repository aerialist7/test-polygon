# test-polygon

This sample reproduces a problem with broken build
when using `-Xir-generate-inline-anonymous-functions` compiler flag with enabled `useEsClasses` compiler option.

To reproduce the problem run `./gradlew build` and see the console output.

Issue: https://youtrack.jetbrains.com/issue/KT-67355
