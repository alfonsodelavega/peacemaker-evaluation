# foe - fail on errors
# bm  - benchmark mode (avgt: average time)
# tu  - time unit
# f   - number of forks (times each benchmark, with iterations and warmups, is repeated)
# i   - number of iterations
# wi  - number of warmup iterations
# gc  - force garbage collection between iterations (currently: false)
# o   - output file (defaults to jhm-result.csv)
# rf  - results format (csv, json, anything else?)

java -jar target/benchmarks.jar -foe true -bm avgt -tu ms -f 1 -i 5 -wi 3 -rf csv