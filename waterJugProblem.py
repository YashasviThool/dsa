from collections import deque

def water_jug_problem(capacity_a, capacity_b, target):
    visited = set()
    initial_state = (0, 0)  # Initial state of both jugs
    queue = deque([(initial_state, [])])  # Queue stores state and path
    while queue:
        current_state, path = queue.popleft()
        if current_state in visited:
            continue
        
        visited.add(current_state)
        
        if current_state[0] == target or current_state[1] == target:
            return path + [current_state]
        
        a, b = current_state
        # Fill jug A
        if a < capacity_a:
            queue.append(((capacity_a, b), path + [current_state]))
        # Fill jug B
        if b < capacity_b:
            queue.append(((a, capacity_b), path + [current_state]))
        # Empty jug A
        if a > 0:
            queue.append(((0, b), path + [current_state]))
        # Empty jug B
        if b > 0:
            queue.append(((a, 0), path + [current_state]))
        # Pour water from A to B
        if a > 0 and b < capacity_b:
            pour_amount = min(a, capacity_b - b)
            queue.append(((a - pour_amount, b + pour_amount), path + [current_state]))
        # Pour water from B to A
        if b > 0 and a < capacity_a:
            pour_amount = min(b, capacity_a - a)
            queue.append(((a + pour_amount, b - pour_amount), path + [current_state]))

    return None  # If no solution is found

# Example usage
capacity_a = int(input("capacity of jug a:"))
capacity_b = int(input("capacity of jug b:"))

target = int(input("target:"))
solution_path = water_jug_problem(capacity_a, capacity_b, target)

if solution_path:
    for state in solution_path:
        print(state)
else:
    print("No solution found.")
