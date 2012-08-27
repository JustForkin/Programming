function [ ret ] = ModifiedDJ( fcn, n )
% Modified DJ algorithm for a 3:1 balanced f


    
    size = 2^n;
    
    state0 = [1; 0];
    state1 = [0; 1];
    
    I = [1 0; 0 1];
    X = [0 1; 1 0];
    
    function [ mat ] = A( isI )
        if isI == 0
            mat = I;
        else mat = X;
        end
    end
    
    H = [1 1; 1 -1]/2^.5;
    Hn = H;
    for i = 1:n-1
        Hn = kron(Hn, H);
    end
    
    top = state0;
    for i = 1:n-1
        top = kron(top, state0);
    end
    bot = state1;
    
    top = (Hn*top);
    bot = (H*bot);
    
    Uf = zeros(2*size, 2*size);
    for j = 1:size
        Utemp = zeros(2*size, 2*size);
        %tempF = F(j);
        tempA = A(F(j));
        Utemp(2*j-1,2*j-1) = tempA(1,1);
        Utemp(2*j-1,2*j) = tempA(1,2);
        Utemp(2*j,2*j-1) = tempA(2,1);
        Utemp(2*j,2*j) = tempA(2,2);
        Uf = Uf + Utemp;
    end
    
    Uf;
    both = kron(top, bot);
    both = Uf*both;
    
    both = kron(Hn,I)*both;
    
  %%% Measure the probability that it's  outcome  0  %%% 
    disp('prob that its outcome 0:');  
    meas0 = zeros(size);
    meas0(1,1) = 1;
    meas0 = kron(meas0, I);
    sol = meas0*both;
    ret = norm(sol)^2
    
    if(ret == 1)
        disp('result: f is balanced');
        ret = 'balanced';
    else
        %pick random  num  0-3
        randNum = floor( rand(1,1)*4);
        if(randNum ~= 1)
            disp('result: f is balanced');
            ret = 'balanced';
        else disp('result: f is constant');
            ret = 'constant';
        end
    end
        
    %%%
%     for h = 1:size-1
%         disp('prob that its outcome');
%         disp(h);
%         t = zeros(size);
%         t(h+1, h+1) = 1;
%         t = kron(t, I);
%         sol = t*both;
%         norm(sol)^2
%     end
    %%%
    
%     disp('prob that its outcome 1');
%     meas1 = zeros(size);
%     meas1(2,2) = 1;
%     meas1 = kron(meas1, I);
%     sol = meas1*both;
%     norm(sol)^2
% 
%     disp('prob that its outcome 2');
%     meas2 = zeros(size);
%     meas2(3,3) = 2;
%     meas2 = kron(meas2, I);
%     sol = meas2*both;
%     norm(sol)^2
    
    function [ fn ] = F( jj )
%         if(isBalanced == true)
%             fn = balanced( jj );
%         else 
%             fn = constant0( jj );
%         end
        fn  =  fcn( jj );
    end

%     function [ ret ] = constant0( i ) %argument just for convenience
%         ret = 0;
%     end
% 
%     function [ ret ] = constant1( i )
%         ret = 1;
%     end
% 
%     function [ ret ] = balanced( i )
%         ret = mod(i,2); %4
%     end
    

end

