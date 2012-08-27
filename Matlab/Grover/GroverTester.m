function [] = GroverTester()
    for i = 1:5
        for j = 0:((2^i)-1)
            fprintf('\nNEW  TEST  CASE: [n=%g, x0=%g]\n', i, j);
            Grover(i, j);
        end
    end
end