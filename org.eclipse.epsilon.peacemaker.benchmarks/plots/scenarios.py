#!/usr/bin/env python

#%%
import pandas as pd
import sys
import matplotlib.pyplot as plt
import numpy as np

if len(sys.argv) == 2:
    filename = sys.argv[1]
else:
    filename = "../jmh-e700123-result.csv"

c_tool = "Tool"
c_bench = "modelsPathName"
c_elems = "numElems"
c_conflicts = "numConflicts"
c_score = "Score"
c_error = "Score Error (99.9%)"

c_pm = "Peacemaker"
c_pm_parallel = "ParallelPeacemaker"
c_emfcompare = "EMFCompare"
c_emfdiffmerge = "EMFDiffMerge"
c_xmiload = "XMILoad"

#%%
df = pd.read_csv(filename)
df.head()

#%%
df.columns = [col.replace("Param: ", "") for col in df.columns]
df.columns

df[c_tool] = df["Benchmark"].apply(lambda b : b.split(".")[-1])
df = df.drop(["Benchmark"], axis=1)

#%%
plt.style.use('seaborn-white')

plt.rc("font", family="sans-serif")

plt.rc("text", usetex=False)

SMALL_SIZE = 14
MEDIUM_SIZE = 16

plt.rc('font', size=SMALL_SIZE)          # controls default text sizes
plt.rc('axes', titlesize=22)     # fontsize of the axes title
plt.rc('axes', labelsize=MEDIUM_SIZE)    # fontsize of the x and y labels
plt.rc('xtick', labelsize=SMALL_SIZE)    # fontsize of the tick labels
plt.rc('ytick', labelsize=SMALL_SIZE)    # fontsize of the tick labels
plt.rc('legend', fontsize=SMALL_SIZE)    # legend fontsize

#%%

measurements = [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel, c_xmiload]
labels = ["EMF DiffMerge", "EMF Compare", "Peacemaker", "Parallel Peacemaker", "XMI Load"]
markers = ["x", "o", "^", "v", "s"]
colors = ["#1965B0", "#7BAFDE", "#4EB265", "#EE8026", "#DC050C"]

def plot_scenario(dfsc, ax):

    for m, label, marker, color in zip(measurements, labels, markers, colors):
        df_aux = dfsc[dfsc[c_tool] == m]
        plot_approach(ax, df_aux, label, marker, color)
    ax.set_ylim(bottom=0)
    ax.set_xlim(0)
    ax.legend()

def plot_approach(ax, df, label, marker, color):
    ax.plot(df[c_elems],
            df[c_score],
            label=label,
            marker=marker,
            color=color)
    ax.errorbar(df[c_elems],
                df[c_score],
                yerr=df[c_error],
                fmt="none",
                capsize=5.0,
                ecolor=color)


#%%
# Scenarios 1 and 2

f = plt.figure(figsize=(6,12))
axes = f.subplots(nrows=2, ncols=1)

ax = axes[0]
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("UpdateDelete Conflicts")
plot_scenario(df[df[c_bench] == "UpdateDeleteTasks"], ax)

ax = axes[1]
ax.set_xlabel("Number of project tasks")
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("DoubleUpdate Conflicts")
plot_scenario(df[df[c_bench] == "DoubleUpdateTasks"], ax)

f.tight_layout()
f.savefig("{}_scenarios12.pdf".format(filename), bbox_inches='tight')

#%%
# Scenario1 with parallel EMFCompare & DiffMerge
f = plt.figure(figsize=(6,6))
ax = f.subplots(nrows=1, ncols=1)

ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("UpdateDelete Conflicts")
plot_scenario(df[df[c_bench] == "UpdateDeleteTasks"], ax)

dfsc = df[df[c_bench] == "UpdateDeleteTasks"]
df_aux = dfsc[dfsc[c_tool] == "ParallelEMFCompare"]
ax.plot(df_aux[c_elems],
        df_aux[c_score],
        label="Parallel Load EMF Compare",
        marker="o",
        color="grey")
df_aux = dfsc[dfsc[c_tool] == "ParallelEMFDiffMerge"]
ax.plot(df_aux[c_elems],
        df_aux[c_score],
        label="Parallel Load EMF DiffMerge",
        marker="o",
        color="black")

ax.legend()


f.tight_layout()
f.savefig("{}_scenarios1_parallel.pdf".format(filename), bbox_inches='tight')

#%%
# Scenario3

f = plt.figure(figsize=(18,12))
axes = f.subplots(nrows=2, ncols=3)

ax = axes[0,0]
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("UpdateDelete, 10% extra changes")
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks10PercChanges"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[0,1]
ax.set_title("UpdateDelete, 50% extra changes")
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks50PercChanges"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[0,2]
ax.set_title("UpdateDelete, 100% extra changes")
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks100PercChanges"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[1,0]
ax.set_title("UpdateDelete, 10% conflicts")
ax.set_xlabel("Number of project tasks")
ax.set_ylabel("Conflict detection time (ms)")
s = "UpdateDeleteTasks10PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[1,1]
ax.set_title("UpdateDelete, 50% conflicts")
ax.set_xlabel("Number of project tasks")
s = "UpdateDeleteTasks50PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[1,2]
ax.set_title("UpdateDelete, 100% conflicts")
ax.set_xlabel("Number of project tasks")
s = "UpdateDeleteTasks100PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)


f.tight_layout()
f.savefig("{}_scenario3.pdf".format(filename), bbox_inches='tight')

# %%
# Scenario 4

f = plt.figure(figsize=(18,6))
axes = f.subplots(nrows=1, ncols=3)

ax = axes[0]
ax.set_ylabel("Conflict detection time (ms)")
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box1 instances")
s = "UpdateDeleteBox1"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[1]
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box10 instances")
s = "UpdateDeleteBox10"
plot_scenario(df[df[c_bench] == s], ax)

ax = axes[2]
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box20 instances")
s = "UpdateDeleteBox20"
plot_scenario(df[df[c_bench] == s], ax)

f.tight_layout()
f.savefig("{}_scenario4.pdf".format(filename), bbox_inches='tight')

#%%
# Relative percentages functions
def score(bench, tool, elems):
    return df[(df[c_bench] == bench) &
              (df[c_tool] == tool) &
              (df[c_elems] == elems)][c_score].iloc[0]

print(score("UpdateDeleteBox20", "EMFCompare", 100000))

# score2 reduces time by XX% over score 1
def time_reduction(score1, score2):
    return 100 * (score1 - score2) / score1

# score2 is XX% faster than score1
def faster_than(score1, score2):
    return 100 * (score1 - score2) / score2

print(time_reduction(2000, 1000))
print(faster_than(2000, 1000))

# %%
benchmarks = df[c_bench].unique()
elems = [50000, 100000, 150000, 200000]

# General comparisons
for bench in benchmarks:
    print("\n" + "*" * 50)
    print(bench)
    print("*" * 50)
    for tool in [c_emfdiffmerge, c_emfcompare, c_pm]:
        accum = 0

        print("200K Score for {}: {:.2f} s".format(tool, score(bench, tool, 200000)))

        for elem in elems:
            value = time_reduction(score(bench, tool, elem),
                                   score(bench, c_pm, elem))
            accum += value
            print("{} vs PM {}: {:.2f}% reduction".format(
                tool, elem, value))
        print("Average reduction {} vs PM: {:.2f}%".format(
              tool, accum / len(elems)))
        print()

        accum = 0
        for elem in elems:
            value = time_reduction(score(bench, tool, elem),
                                   score(bench, c_pm_parallel, elem))
            accum += value
            print("{} vs PM Parallel {}: {:.2f}% reduction".format(
                tool, elem, value))
        print("Average reduction {} vs PM Par: {:.2f}%".format(
              tool, accum / len(elems)))
        print()

print("@" * 50)

#%%
# Improvements of double update for pm and pm par

for tool in [c_pm, c_pm_parallel]:
    accum = 0
    for elem in elems:
        value = time_reduction(score("UpdateDeleteTasks", tool, elem),
                               score("DoubleUpdateTasks", tool, elem))
        accum += value
    print("Average reduction UpdateDelete {} vs DoubleUpdate {}: {:.2f}%".format(
            tool, tool, accum / len(elems)))
    print()

# %%
# Parallel EMFCompare and Diffmerge
print("@" * 50)

for tool, par_tool in [(c_emfdiffmerge, "Parallel" + c_emfdiffmerge),
                       (c_emfcompare, "Parallel" + c_emfcompare)]:
    accum = 0
    for elem in elems:
        value = time_reduction(score("UpdateDeleteTasks", tool, elem),
                               score("UpdateDeleteTasks", par_tool, elem))
        accum += value
    print("UpdateDelete Average reduction {} vs {}: {:.2f}%".format(
            tool, par_tool, accum / len(elems)))
    print()
