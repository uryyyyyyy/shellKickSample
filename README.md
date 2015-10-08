
## how to run shell inside of jar.

normally, file inside of jar is zipped file.
so process(shell) cannot read it.

so this impl, I create tempFile and copy it, then process read tempFile.