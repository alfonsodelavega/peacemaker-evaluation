# foe - fail on errors
# bm  - benchmark mode (avgt: average time)
# tu  - time unit
# f   - number of forks (times each benchmark, with iterations and warmups, is repeated)
# i   - number of iterations
# wi  - number of warmup iterations
# r   - minimum seconds for iteration (repeats benchmark call if not yet reached, then averages)
# w   - minimum seconds for warmup iteration
# gc  - force garbage collection between iterations
# o   - output file (defaults to jhm-result.csv)
# rf  - results format (csv, json, anything else?)

java -jar target/benchmarks.jar -foe true -bm avgt -tu ms -f 1 -i 10 -wi 5 -r 2 -w 2 -rf csv
