#!/usr/bin/env python

#%%
import pandas as pd
import sys
import matplotlib.pyplot as plt
import numpy as np

if len(sys.argv) == 2:
    filename = sys.argv[1]
else:
    filename = "../jmh-e8e5d7-result.csv"

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

plt.rcParams.update({
    "text.usetex": True,
    "font.family": "sans-serif",
    "font.sans-serif": ["Computer Modern Sans Serif"],
    "text.latex.preamble" : "\\usepackage{sfmath}"})

SMALL_SIZE = 18
MEDIUM_SIZE = 20

title_pad = 8

plt.rc('font', size=SMALL_SIZE)          # controls default text sizes
plt.rc('axes', titlesize=24)     # fontsize of the axes title
plt.rc('axes', labelsize=MEDIUM_SIZE)    # fontsize of the x and y labels
plt.rc('xtick', labelsize=SMALL_SIZE)    # fontsize of the tick labels
plt.rc('ytick', labelsize=SMALL_SIZE)    # fontsize of the tick labels
plt.rc('legend', fontsize=SMALL_SIZE)    # legend fontsize

#%%

blue_dark = "#1965B0"
blue_light = "#7BAFDE"

red_dark = "#DC050C"
red_light = "#EE8026"

green_dark = "#4EB265"
green_light = "#CAE0AB"

violet_dark = "#882E72"

measurements = [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel, c_xmiload]
labels = ["EMF DiffMerge", "EMF Compare", "Peacemaker", "Parallel Peacemaker", "XMI Load"]
markers = ["x", "o", "^", "v", "s"]
colors = [blue_dark, green_dark, red_dark, red_light, violet_dark]

def plot_scenario(dfsc, ax):

    for m, label, marker, color in zip(measurements, labels, markers, colors):
        df_aux = dfsc[dfsc[c_tool] == m]
        plot_approach(ax, df_aux, label, marker, color)
    ax.set_ylim(bottom=0)
    ax.set_xlim(0)
    ax.legend()
    ax.tick_params(axis=u'both', which=u'both',length=5)

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
ax.set_title("UpdateDelete Conflicts", pad=title_pad)
plot_scenario(df[df[c_bench] == "UpdateDeleteTasks"], ax)

ax = axes[1]
ax.set_xlabel("Number of project tasks")
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("DoubleUpdate Conflicts", pad=title_pad)
plot_scenario(df[df[c_bench] == "DoubleUpdateTasks"], ax)

ax.tick_params(axis=u'both', which=u'both',length=5)

f.tight_layout()
f.savefig("{}_scenarios12.pdf".format(filename), bbox_inches='tight')

#%%
# Scenario1 with parallel EMFCompare & DiffMerge
def swap_legend_item(handles, labels, _from, _to):
    handles[_to], handles[_from] = handles[_from], handles[_to]
    labels[_to], labels[_from] = labels[_from], labels[_to]

f = plt.figure(figsize=(7,6))
ax = f.subplots(nrows=1, ncols=1)

ax.set_xlabel("Number of project tasks")
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("UpdateDelete Conflicts", pad=title_pad)
plot_scenario(df[df[c_bench] == "UpdateDeleteTasks"], ax)

dfsc = df[df[c_bench] == "UpdateDeleteTasks"]
df_aux = dfsc[dfsc[c_tool] == "ParallelEMFCompare"]

plot_approach(ax, df_aux, "Parallel Load EMF Compare", "D", green_light)

df_aux = dfsc[dfsc[c_tool] == "ParallelEMFDiffMerge"]
plot_approach(ax, df_aux, "Parallel Load EMF DiffMerge", "X", blue_light)

ax.legend()

handles, labels = ax.get_legend_handles_labels()
new_handles = []
new_labels = []

new_order = [0, 6, 1, 5, 2, 3, 4]

for order in new_order:
    new_handles.append(handles[order])
    new_labels.append(labels[order])

ax.legend(new_handles, new_labels)

f.tight_layout()
f.savefig("{}_scenarios1_parallel.pdf".format(filename), bbox_inches='tight')

#%%
# Scenario3

plt.rc('legend', fontsize=20)

f = plt.figure(figsize=(18,12))
axes = f.subplots(nrows=2, ncols=3)

ax = axes[0,0]
ax.set_ylabel("Conflict detection time (ms)")
ax.set_title("UpdateDelete, 10\% extra changes", pad=title_pad)
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks10PercChanges"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=16000)

ax = axes[0,1]
ax.set_title("UpdateDelete, 50\% extra changes", pad=title_pad)
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks50PercChanges"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=16000)

ax = axes[0,2]
ax.set_title("UpdateDelete, 100\% extra changes", pad=title_pad)
ax.set_ylim(top=22500)
s = "UpdateDeleteTasks100PercChanges"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=16000)

ax = axes[1,0]
ax.set_title("UpdateDelete, 10\% conflicts", pad=title_pad)
ax.set_xlabel("Number of project tasks")
ax.set_ylabel("Conflict detection time (ms)")
s = "UpdateDeleteTasks10PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=14000)

ax = axes[1,1]
ax.set_title("UpdateDelete, 50\% conflicts", pad=title_pad)
ax.set_xlabel("Number of project tasks")
s = "UpdateDeleteTasks50PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=14000)

ax = axes[1,2]
ax.set_title("UpdateDelete, 100\% conflicts", pad=title_pad)
ax.set_xlabel("Number of project tasks")
s = "UpdateDeleteTasks100PercConflicts"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=14000)


f.tight_layout()
f.savefig("{}_scenario3.pdf".format(filename), bbox_inches='tight')

# %%
# Scenario 4

plt.rc('legend', fontsize=20)

f = plt.figure(figsize=(18,6))
axes = f.subplots(nrows=1, ncols=3)

plt.yticks()

top_y_lim = 9000

ax = axes[0]
ax.set_ylabel("Conflict detection time (ms)")
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box1 instances", pad=title_pad)
s = "UpdateDeleteBox1"
plot_scenario(df[df[c_bench] == s], ax)
ax.legend(loc="upper left")
ax.set_ylim(bottom=0, top=top_y_lim)
ax.set_yticks(np.arange(0, top_y_lim + 1, 1500))

ax = axes[1]
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box10 instances", pad=title_pad)
s = "UpdateDeleteBox10"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=top_y_lim)
ax.set_yticks(np.arange(0, top_y_lim + 1, 1500))

ax = axes[2]
ax.set_xlabel("Number of boxes")
ax.set_title("UpdateDelete, Box20 instances", pad=title_pad)
s = "UpdateDeleteBox20"
plot_scenario(df[df[c_bench] == s], ax)
ax.set_ylim(bottom=0, top=top_y_lim)
ax.set_yticks(np.arange(0, top_y_lim + 1, 1500))

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

# score2 is X times faster than score1
def times_faster(score1, score2):
    return times_from_reduction(time_reduction(score1, score2))

def times_from_reduction(reduction):
    return 100 / (100 - reduction)

print(time_reduction(2000, 1000))
print(time_reduction(1000, 2000))
print(times_faster(2000, 1000))

# %%
elems = [50000, 100000, 150000, 200000]

def avg_fun(bench, tool1, tool2, funct):
    accum = 0
    for elem in elems:
        value = funct(score(bench, tool1, elem),
                      score(bench, tool2, elem))
        accum += value
        print("{} vs {}, {}: {:.2f}".format(
            tool1, tool2, elem, value))
    return accum / len(elems)

def avg_reduction(bench, tool1, tool2):
    return avg_fun(bench, tool1, tool2, time_reduction)

def avg_times(bench, tool1, tool2):
    return avg_fun(bench, tool1, tool2, times_faster)

# for different benchmarks
def extra_avg_fun(bench1, bench2, tool1, tool2, funct):
    accum = 0
    for elem in elems:
        value = funct(score(bench1, tool1, elem),
                      score(bench2, tool2, elem))
        accum += value
        print("{} vs {}, {}: {:.2f}".format(
            tool1, tool2, elem, value))
    return accum / len(elems)

def extra_avg_reduction(bench1, bench2, tool1, tool2):
    return extra_avg_fun(bench1, bench2, tool1, tool2, time_reduction)

def extra_avg_times(bench1, bench2, tool1, tool2):
    return extra_avg_fun(bench1, bench2, tool1, tool2, times_faster)

#%%
# Scenario 1

def analyse_benchmark(bench):
    print("*" * 50)
    print(bench)
    print("*" * 50)
    print()
    for tool in [c_emfdiffmerge, c_emfcompare, c_pm]:
        if (tool != c_pm):
            print("200K Score for {}: {:.2f} s".format(
                tool, score(bench, tool, 200000)))
            print("Average reduction {} vs PM: {:.2f}%".format(
              tool, avg_reduction(bench, tool, c_pm)))
            print()

        print("Average reduction {} vs PM Parallel: {:.2f}%".format(
              tool, avg_reduction(bench, tool, c_pm_parallel)))
        print()

    print("200K Score for {}: {:.2f} s".format(
            c_pm_parallel, score(bench, c_pm_parallel, 200000)))
    print()

    for tool in [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel]:
        print("{} times XMI Load: {:.2f}".format(
              tool, avg_times(bench, tool, c_xmiload)))
        print()

analyse_benchmark("UpdateDeleteTasks")

#%%
# Improvements of double update for pm and pm par
print ("DoubleUpdate improvement over UpdateDelete\n")

for tool in [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel]:
    print("Avg red. UpdateDelete vs DoubleUpdate {}: {:.2f}%"
          .format(tool,
                  extra_avg_reduction("UpdateDeleteTasks",
                                      "DoubleUpdateTasks",
                                      tool,
                                      tool)))
    print()

# %%
# Parallel EMFCompare and Diffmerge
print("@" * 50)

for tool, par_tool in [(c_emfdiffmerge, "Parallel" + c_emfdiffmerge),
                       (c_emfcompare, "Parallel" + c_emfcompare)]:

    print("UpdateDelete Average reduction {} vs {}: {:.2f}%"
          .format(tool,
                  par_tool,
                  avg_reduction("UpdateDeleteTasks", tool, par_tool)))
    print()

#%%
# Scenario 3, extra changes
benchmarks = ['UpdateDeleteTasks10PercChanges',
              'UpdateDeleteTasks50PercChanges',
              'UpdateDeleteTasks100PercChanges']
base_bench = "UpdateDeleteTasks"

for bench in benchmarks:
    for tool in [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel]:
        print("Avg red. {} vs UpdateDelete {}: {:.2f}%"
          .format(bench, tool,
                  extra_avg_reduction(base_bench,
                                      bench,
                                      tool,
                                      tool)))
        print()

#%%
# Scenario 3, conflicts
benchmarks = ['UpdateDeleteTasks10PercConflicts',
              'UpdateDeleteTasks50PercConflicts',
              'UpdateDeleteTasks100PercConflicts']
base_bench = "UpdateDeleteTasks"

for tool in [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel]:
    for bench in benchmarks:
        print("Avg red. {} vs UpdateDelete {}: {:.2f}%"
          .format(bench, tool,
                  extra_avg_reduction(base_bench,
                                      bench,
                                      tool,
                                      tool)))
        print()

#%%
# Scenario 4, xmi load times
for bench in ['UpdateDeleteBox1', 'UpdateDeleteBox10', 'UpdateDeleteBox20']:
    print("XMI Load score for {} 200K: {:.2f}"
          .format(bench, score(bench, c_xmiload, 200000)))

# %%
# Scenario 4, boxes1 against box10 and box20
benchmarks = ['UpdateDeleteBox10', 'UpdateDeleteBox20']
base_bench = 'UpdateDeleteBox1'

for tool in [c_emfdiffmerge, c_emfcompare, c_pm, c_pm_parallel]:
    for bench in benchmarks:
        print("Avg red. {} vs Box1 {}: {:.2f}%"
              .format(bench, tool,
                      extra_avg_reduction(base_bench,
                                          bench,
                                          tool,
                                          tool)))
        print()

# %%
# Scenario 4, Box20
analyse_benchmark("UpdateDeleteBox20")

# %%
