# foe - fail on errors
# bm  - benchmark mode (avgt: average time, ss: single shot time)
# tu  - time unit
# f   - number of forks (times each benchmark, with iterations and warmups, is repeated)
# i   - number of iterations
# wi  - number of warmup iterations
# gc  - force garbage collection between iterations (currently: false)

java -jar target/benchmarks.jar -foe true -bm ss -tu ms -f 1 -rf csv