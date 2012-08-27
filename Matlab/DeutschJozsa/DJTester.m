function [ ] = DJTester( num )

    disp('CONSTANT:');
    DeutschJozsa(@constant0, num);
    disp(' ');
    disp('CONSTANT:');
    DeutschJozsa(@constant1, num);
    disp(' ');
    disp('BALANCED:');
    DeutschJozsa(@balanced, num);
    disp(' ');
    disp(' ');
    disp('~modified~');
    disp(' ');
    disp('CONSTANT:');
    ModifiedDJ(@constant0, num);
    disp(' ');
    disp('BALANCED:');
    ModifiedDJ(@balancedM, num);
    
    %%% Uncomment to simulate the modified algorithm many times %%%
%     disp(' ');
%     disp(' ');
%     disp('run the modified algorithm on a 3:1 balanced function many times');
%     Bs = 0;
%     Cs = 0;
%     for i = 1:1000
%         if(ModifiedDJ(@balancedM, num) == 'constant')
%             Cs = Cs+1;
%         else Bs = Bs+1;
%         end
%     end
%     disp(' ');
%     disp(' ');
%     disp('fraction that are balanced');
%     disp(Bs/(Cs+Bs));

    function [ ret ] = constant0( i ) %argument just for convenience
        ret = 0;
    end

    function [ ret ] = constant1( i )
        ret = 1;
    end

    function [ ret ] = balanced( i )
        ret = mod(i,2); 
    end

    function [ ret ] = balancedM( i )
        ret = mod(i,4);
        if(ret ~= 0)
            ret = 1;
        end
    end

end